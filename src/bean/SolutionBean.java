package bean;

import java.sql.Blob;
import java.sql.Date;

public class SolutionBean {
	private String solutionid;
	private String solutionname;
	private Blob solutionset;
	private Date datesubmited;
	public String getSolutionid() {
		return solutionid;
	}
	public void setSolutionid(String solutionid) {
		this.solutionid = solutionid;
	}
	public String getSolutionname() {
		return solutionname;
	}
	public void setSolutionname(String solutionname) {
		this.solutionname = solutionname;
	}
	public Blob getSolutionset() {
		return solutionset;
	}
	public void setSolutionset(Blob solutionset) {
		this.solutionset = solutionset;
	}
	public Date getDatesubmited() {
		return datesubmited;
	}
	public void setDatesubmited(Date datesubmited) {
		this.datesubmited = datesubmited;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((solutionid == null) ? 0 : solutionid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SolutionBean other = (SolutionBean) obj;
		
		if (solutionid == null) {
			if (other.solutionid != null)
				return false;
		} else if (!solutionid.equals(other.solutionid))
			return false;
		return true;
	}
	
}
