package tabviewadpt;

import java.util.ArrayList;

import javax.security.auth.PrivateCredentialPermission;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabview.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import database.Datahelper;

public class MapFrag extends Fragment{

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_map	, container, false);
        Datahelper dh=new Datahelper(this.getActivity());
        ArrayList<String> names=new ArrayList<String>();
        ArrayList<String> lat=new ArrayList<String>();
        ArrayList<String> long1=new ArrayList<String>();
        
        names=dh.showall();
        lat=dh.getLat();
        long1=dh.getLong();
         GoogleMap map; 
         //map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
			//        .getMap();
         map=((MapFragment)getActivity().getFragmentManager().findFragmentById(R.id.map)).getMap();
         map.clear();
         LatLng latlng = null;
         double lati,lon;
         
         for(int i=0;i<names.size();i++)
         {
        	  lati=Double.parseDouble(lat.get(i));
        	    lon=Double.parseDouble(long1.get(i));
        	 map.addMarker(new MarkerOptions().position(new LatLng(lati, lon))
        			 .title(names.get(i))
        			 .snippet(names.get(i)));
        	 
        	  latlng=new LatLng(lati, lon);
         }
        
        			   
       //  map.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(lati, lon), 15));
         map.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, 20));
         // Zoom in, animating the camera.
		    map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);

        
        
        return rootView;
    }
}
