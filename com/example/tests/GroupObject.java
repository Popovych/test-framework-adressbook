package com.example.tests;

public class GroupObject {
	public String name;
	public String header;
	public String footer;
	public String id;
	
	
	public GroupObject setName(String inputText1) {
		this.name = inputText1;
		return this;
	}

	public GroupObject setHeader(String inputText2) {
		this.header = inputText2;
		return this;
	}

	public GroupObject setFooter(String inputText3) {
		this.footer = inputText3;
		return this;
	}

	public GroupObject setId(String id) {
		this.id = id;
		return this;
	}

	
	@Override
	public String toString()
	{
		return "Group ["+id +": " + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		GroupObject other = (GroupObject) obj;
		
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		
		if (id != null && other.id != null ) {
				return id.equals(other.id);
		}
		return true;
	}
	
	
	
	
	
}