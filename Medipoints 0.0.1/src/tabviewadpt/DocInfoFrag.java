package tabviewadpt;


import java.io.IOException;
import java.util.List;
import java.util.Locale;


import com.example.tabview.R;

import database.Datahelper;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.DocumentsContract.Root;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DocInfoFrag extends Fragment{
	TextView txt_lat,txt_long,txt_addr;
	EditText edt_docname,edt_surname,edt_edu,edt_spec,edt_exp;
	Button show_addr,insert,show;
	Datahelper dh;

	
	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_doc_info	, container, false);
        
		txt_addr=(TextView)rootView.findViewById(R.id.txt_addr);
		txt_long=(TextView)rootView.findViewById(R.id.txt_long);
		txt_lat=(TextView)rootView.findViewById(R.id.txt_lat);
		edt_docname=(EditText)rootView.findViewById(R.id.edt_docname);
        edt_surname=(EditText)rootView.findViewById(R.id.edt_surname);
        edt_edu=(EditText)rootView.findViewById(R.id.edt_edu);
        edt_spec=(EditText)rootView.findViewById(R.id.edt_spec);
        edt_exp=(EditText)rootView.findViewById(R.id.edt_exp);
        show_addr=(Button)rootView.findViewById(R.id.show_btn);
        show=(Button)rootView.findViewById(R.id.show);
        insert=(Button)rootView.findViewById(R.id.insert);
        dh=new Datahelper(this.getActivity());
        show_addr.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final LocationManager lm=(LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);
				
				final LocationListener ll=new MyLocList();
				
				lm.requestLocationUpdates(lm.GPS_PROVIDER,100000,10000,ll);
				
				
				
			}
			
			
		});
        
       insert.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
		
		dh.insert(edt_docname.getText().toString(),
				edt_surname.getText().toString(),
				edt_edu.getText().toString(), 
				edt_spec.getText().toString(),
				Float.parseFloat(edt_exp.getText().toString()),
				Float.parseFloat(txt_lat.getText().toString()),
				Float.parseFloat(txt_long.getText().toString()), 
				txt_addr.getText().toString());	
		Toast.makeText(getActivity(),"Inserted",Toast.LENGTH_SHORT).show();
			
			
		}
	}) ;
       /*show.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String x=dh.showall();
			Toast.makeText(getActivity(),x,Toast.LENGTH_SHORT).show();
		}
	});*/
 return rootView;
    }
  public class MyLocList implements LocationListener
	{

		@Override
		public void onLocationChanged(Location location) {
			
			location.getLatitude();
			location.getLongitude();
			updateWithNewLoc(location);
			
			
			
		}

		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			Toast.makeText(getActivity(), "GPS disabled",Toast.LENGTH_SHORT).show();
			
		}

		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			Toast.makeText(getActivity(), "GPS enabled",Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			
		}
		
		public void updateWithNewLoc(final Location location)
		{
			String addr="No address found";
			if(location!=null)
			{
				
				//Toast.makeText(getActivity(),Double.toString(location.getAccuracy()),Toast.LENGTH_LONG).show();
				final double lat=location.getLatitude();
				final double long1=location.getLongitude();
				txt_lat.setText(Double.toString(lat));
				txt_long.setText(Double.toString(long1));
				final Geocoder gc=new Geocoder(getActivity(),Locale.getDefault());
				try{
					
					final List<Address> address=gc.getFromLocation(lat, long1,2);
					final StringBuilder sb=new StringBuilder();
					if(address.size()>0)
					{
						final Address add=address.get(0);
						for (int i=0;i<add.getMaxAddressLineIndex();i++)
						{
							sb.append(add.getAddressLine(i)).append("\n");
						}
						sb.append(add.getLocality()).append("\n");
					}
					addr=sb.toString();
					
				}catch(final IOException e){	}
			}
			txt_addr.setText(addr);
			//Toast.makeText(getActivity(),addr,Toast.LENGTH_LONG).show();
		}

		
	}
		 
}
	




