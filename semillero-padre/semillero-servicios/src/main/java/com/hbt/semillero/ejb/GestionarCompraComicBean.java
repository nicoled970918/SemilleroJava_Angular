package com.hbt.semillero.ejb;

import java.time.LocalDate;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.hbt.semillero.dto.CompraComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.entidad.Comic;
import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.interfaces.IGestionarCompraComic;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GestionarCompraComicBean implements IGestionarCompraComic
{
	@PersistenceContext
	public EntityManager em;
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ResultadoDTO compraComic(CompraComicDTO compraComic) throws Exception
	{
		Comic comic = new Comic();
		ResultadoDTO resultadoDTO = new ResultadoDTO();
		
		String queryComic = "SELECT c FROM Comic c WHERE c.id = :idComic";
		
		try {
			Query consultaCompraComic = em.createQuery(queryComic);
			consultaCompraComic.setParameter("idComic", compraComic.getIdComic());
			comic = (Comic) consultaCompraComic.getSingleResult();
			
			if(comic.getEstadoEnum().equals(EstadoEnum.INACTIVO))
			{
				throw new Exception("El comic seleccionado no cuenta con stock en bodega");
			}
			else if(comic.getCantidad()>=compraComic.getCantidad() ) 
			{
				
				Long modificarCantidad = comic.getCantidad() - compraComic.getCantidad();
				
				comic.setCantidad(modificarCantidad);
				comic.setFechaVenta(LocalDate.now());
				
				if (modificarCantidad == 0)
				{
					comic.setEstadoEnum(EstadoEnum.INACTIVO);
				}
				
				em.merge(comic);
				
				resultadoDTO.setExitoso(true);
				resultadoDTO.setMensajeEjecucion("La compra del comic " + comic.getNombre() + " fue exitosa");
			}
			else
			{
				throw new Exception("La cantidad existente del comic es:" +  comic.getCantidad() + ", y supera la ingresada");
			}
		} 
		catch (Exception e) 
		{
			resultadoDTO.setExitoso(false);
			resultadoDTO.setMensajeEjecucion("La cantidad existente del comic es: " + comic.getCantidad() +", y supera la ingresada");
			return resultadoDTO;
		}
		return resultadoDTO;
	}
}
