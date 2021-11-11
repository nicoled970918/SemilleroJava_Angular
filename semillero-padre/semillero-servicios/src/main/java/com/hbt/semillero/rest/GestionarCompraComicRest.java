package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.CompraComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.interfaces.IGestionarCompraComic;

@Path("/gestionarCompraComic")
public class GestionarCompraComicRest 
{
	@EJB
	private IGestionarCompraComic gestionarCompraComic;
	
	@POST
	@Path("/compraComic")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO compraComic(CompraComicDTO compraComic)
	{
		ResultadoDTO comicDTOResult = new ResultadoDTO();
		try {
			comicDTOResult = this.gestionarCompraComic.compraComic(compraComic);
		}  catch (Exception e) {
			comicDTOResult.setExitoso(false);
			comicDTOResult.setMensajeEjecucion("Se ha presentado un error tecnico, causa: " + e.getMessage());
		}
		return comicDTOResult;
	}
}
