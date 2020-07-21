package idat.edu.pe.appjeanherrera.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idat.edu.pe.appjeanherrera.R;
import idat.edu.pe.appjeanherrera.adapter.ClienteAdapter;


public class Fragment1 extends Fragment {

    private RequestQueue colaPeticion;
    private List<Map<String,String>> lista;
    private ClienteAdapter adapter;
    RecyclerView rvDatos;

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_1, container, false);

        lista = new ArrayList<>();
         rvDatos = view.findViewById(R.id.rvDatos);
         rvDatos.setLayoutManager(new GridLayoutManager(getContext(),2));
         adapter = new ClienteAdapter(getContext());

        rvDatos.setAdapter(adapter);

        colaPeticion = Volley.newRequestQueue(getContext());
        consumirServicioWeb();

        return view;
    }

    private void consumirServicioWeb(){
        String url = "https://jsonplaceholder.typicode.com/todos";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {

                    for (int i=0;i< response.length();i++){
                        JSONObject object = response.getJSONObject(i);

                        if(Integer.parseInt(object.getString("userId"))%2 != 0){

                            Map<String,String> mapa = new HashMap<>();
                            mapa.put("userId",object.getString("userId"));
                            mapa.put("id",object.getString("id"));
                            mapa.put("title",object.getString("title"));
                            mapa.put("completed",object.getString("completed"));

                            lista.add(mapa);
                        }
                    }

                    adapter.agregarDatos(lista);

                    //System.out.println("mapa"+lista);

                } catch (JSONException ex) {
                    System.out.println(ex.getCause().getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.getCause().getMessage());
            }
        });

        colaPeticion.add(request);
    }
}