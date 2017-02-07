package com.wegneto.madlibs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wegneto.madlibs.model.BaseModel;

public abstract class BaseController<T extends BaseModel> {

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public abstract void delete(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response);

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public abstract T get(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response);

	@RequestMapping(value = "", method = RequestMethod.GET)
	public abstract Page<T> list(@PathVariable(value = "p", required = false) Integer page, HttpServletRequest request,
			HttpServletResponse response);

	@RequestMapping(value = "", method = RequestMethod.POST)
	public abstract T save(@Validated @RequestBody T object, HttpServletRequest request, HttpServletResponse response);
}
