package files;

import java.util.ArrayList;
import java.util.List;

import pocoFiles.Location;
import pocoFiles.Serialzation;

public class SerializationPaylaod {
	
	public static void main(String[] args) {
		
		Serialzation bodydata= new Serialzation();
		
		bodydata.setAccuracy(50);
		bodydata.setAddress("test address");
		bodydata.setLanguage("English");
		bodydata.setName("AjayMareedu");
		bodydata.setPhone_number("98797979797");
		List<String> Mylist = new ArrayList<String>();
		Mylist.add("Near Adress");
		Mylist.add("TESTlIST");
		bodydata.setTypes(Mylist);
		Location L = new Location();
		L.setLat(-9879879);
		L.setLng(+878788);
		bodydata.setLocation(L);
		
		
	}
}
