package tabviewadpt;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.example.tabview.R;

import database.Datahelper;

public class ListDoc extends Fragment{

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_list_doc	, container, false);
       Datahelper dh=new Datahelper(this.getActivity());
       ArrayList<String> values=new ArrayList<String>();
       ListView lv=(ListView)rootView.findViewById(R.id.listView1);
      
       values=dh.showall();
       ArrayAdapter<String> adpt=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,values);
       
      
       lv.setAdapter(adpt);
       
       
         
        return rootView;
    }
}

 