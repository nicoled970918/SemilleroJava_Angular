package com.hbt.semillero.interfaces;

import com.hbt.semillero.dto.CompraComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;

public interface IGestionarCompraComic 
{
	public ResultadoDTO compraComic(CompraComicDTO compraComic) throws Exception;
}
