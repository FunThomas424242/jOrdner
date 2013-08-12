package com.gh.jordner.api;

/**
 * 
 * @author SchubertT006
 * @deprecated Please use only VerzeichnisImpl of the jOrdner.jpa project
 */
@Deprecated
public interface Verzeichnis {

	public Long getId();

	public void setId(Long id);

	public String getName();

	public void setName(String name);

	public String getParentPathURI();

	public void setParentPathURI(String parentPathURI);

}
