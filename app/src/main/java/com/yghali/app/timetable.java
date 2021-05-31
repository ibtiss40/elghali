package com.yghali.app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.yghali.app.Model.Tache;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link timetable#newInstance} factory method to
 * create an instance of this fragment.
 */
public class timetable extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static final String HTTP_BASE ="https://emploisclub.000webhostapp.com/GetTache.php";
    private Tache tache;
    public static List<Tache> taches = new ArrayList<>();
    RequestQueue requestQueue;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public timetable() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment timetable.
     */
    // TODO: Rename and change types and number of parameters
    public static timetable newInstance(String param1, String param2) {
        timetable fragment = new timetable();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_timetable, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        ListView listetask = view.findViewById(R.id.listtache);
//        AdapterTache an = new AdapterTache(getContext(), Tache.listtache);
//        listetask.setAdapter(an);
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, HTTP_BASE, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            if(response.has("error")){
//                                Log.d("1","npp");
//                                Toast.makeText(timetable.this.getContext(),response.getString("error"),Toast.LENGTH_LONG).show();
//                            } else{
//                                if(response !=null)
//                                {
//                                    if(response.has("data")){
//
//                                        JSONArray data = response.getJSONArray("data");
//                                        for (int i = 0; i < data.length(); i++) {
//                                            String name = data.getJSONObject(i).getString("name");
//                                            // String description = data.getJSONObject(i).getString("description");
//                                            String time = data.getJSONObject(i).getString("dateStart");
//                                            tache = new Tache(name, time);
//                                            taches.add(tache); }
//                                    }  }
//                                if(taches !=null)
//                                {    AdapterTache na = new AdapterTache(timetable.this.getContext(),taches);
//                                }
//                            }
//                        } catch (JSONException e) {
//                            e.getMessage();
//                            e.printStackTrace();
//                            Log.d("2","err");
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError volleyError) {
//                        NetworkResponse networkResponse = volleyError.networkResponse;
//
//                        if (networkResponse != null && networkResponse.data != null) {
//                            Log.d("1","mm");
//                            String jsonError = new String(networkResponse.data);}
//                        Log.d("2","erreur");
//                        Toast.makeText(getContext(), volleyError.getMessage(), Toast.LENGTH_SHORT).show();
//                        Log.e(timetable.class.getSimpleName(), volleyError.getMessage());
//                    }
//                }
//        );
//        Volley.newRequestQueue(this.getContext()).add(request);
//        listetask.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                deletetache dt = new deletetache(getContext());
//                dt.show();
//                Button supp = dt.findViewById(R.id.supprimer);
//                supp.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        taches.remove(position);
//                        an.notifyDataSetChanged();
//                        listetask.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                listetask.setSelection(taches.size() -1);
//                                Log.d("1","no");
//                                dt.dismiss();
//                            }
//                        });
//
//
//                    }
//                });
//            }
//        });

    }

    @Override
    public void onResume() {
        super.onResume();
        ListView listetask = getView().findViewById(R.id.listtache);
        AdapterTache an = new AdapterTache(getContext(), Tache.listtache);
        listetask.setAdapter(an);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, HTTP_BASE, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if(response.has("error")){
                                Toast.makeText(timetable.this.getContext(),response.getString("error"),Toast.LENGTH_LONG).show();
                            } else{
                                if(response !=null)
                                {
                                    if(response.has("data")){
                                        JSONArray data = response.getJSONArray("data");
                                        for (int i = 0; i < data.length(); i++) {
                                            String name = data.getJSONObject(i).getString("name");
                                            // String description = data.getJSONObject(i).getString("description");
                                            String time = data.getJSONObject(i).getString("dateStart");
                                            tache = new Tache(name, time);
                                            taches.add(tache);
                                            Log.d("1","wa khdem");}
                                    }  }
                                if(taches !=null)
                                {
                                    AdapterTache na = new AdapterTache(timetable.this.getContext(),taches);
                                    listetask.setAdapter(na);
                                }
                            }
                        } catch (JSONException e) {
                            e.getMessage();
                            e.printStackTrace();
                            Log.d("2","err");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        NetworkResponse networkResponse = volleyError.networkResponse;

                        if (networkResponse != null && networkResponse.data != null) {
                            Log.d("1","mm");
                            String jsonError = new String(networkResponse.data);}
                        Log.d("2","erreur");
                        Toast.makeText(getContext(), volleyError.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.e(timetable.class.getSimpleName(), volleyError.getMessage());
                    }
                }
        );
        Volley.newRequestQueue(this.getContext()).add(request);
        listetask.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                deletetache dt = new deletetache(getContext());
                dt.show();
                Button supp = dt.findViewById(R.id.supprimer);
                supp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        taches.remove(position);
                        an.notifyDataSetChanged();
                        listetask.post(new Runnable() {
                            @Override
                            public void run() {
                                listetask.setSelection(taches.size() -1);
                                Log.d("1","no");
                                dt.dismiss();
                            }
                        });


                    }
                });
            }
        });
    }
}