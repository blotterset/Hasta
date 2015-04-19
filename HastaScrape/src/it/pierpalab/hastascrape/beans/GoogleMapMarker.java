package it.pierpalab.hastascrape.beans;

import it.pierpalab.hastascrape.interfaces.MapMarker;

public class GoogleMapMarker implements MapMarker {
		String longitude;
		String latitude;
		String comment;
	@Override
	public String getLongitude() {
		return longitude;
	}

	@Override
	public String getLatitude() {
		return latitude;
	}

	@Override
	public String getComment() {
		if (comment == null)
			return "";
		return comment;
	}

	public GoogleMapMarker(String longitude, String latitude, String comment) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
		this.comment = comment;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GoogleMapMarker [longitude=").append(longitude)
				.append(", latitude=").append(latitude).append(", comment=")
				.append(comment).append("]");
		return builder.toString();
	}
	
	
	
	

}
