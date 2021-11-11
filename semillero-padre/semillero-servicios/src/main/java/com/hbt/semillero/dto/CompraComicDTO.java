package com.hbt.semillero.dto;

public class CompraComicDTO extends ResultadoDTO
{
	private static final long serialVersionUID = 1L;
	
	private Long idComic;
	private Long cantidad;
	
	public CompraComicDTO()
	{
		
	}
	
	public CompraComicDTO(Long idComic, Long cantidad)
	{
		this.idComic = idComic;
		this.cantidad = cantidad;
	}
	
	public Long getIdComic() {
		return idComic;
	}

	public void setIdComic(Long idComic) {
		this.idComic = idComic;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

}
