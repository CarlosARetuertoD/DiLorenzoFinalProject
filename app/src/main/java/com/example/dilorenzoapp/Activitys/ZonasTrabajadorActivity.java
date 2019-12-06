package com.example.dilorenzoapp.Activitys;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.example.dilorenzoapp.Clases.Producto;
import com.example.dilorenzoapp.Clases.ZonaTrabajador;
import com.example.dilorenzoapp.InterfazServicios;
import com.example.dilorenzoapp.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ZonasTrabajadorActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    String user_dni;
    SupportMapFragment mapFragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zonas_trabajador);
        fragmentManager = getSupportFragmentManager();
        ObtenerDni();
        fragmentTransaction = fragmentManager.beginTransaction();
        mapFragment = new SupportMapFragment();
        mapFragment.getMapAsync(this);
        fragmentTransaction.add(R.id.container, mapFragment);
        fragmentTransaction.commit();

    }
    void ObtenerDni(){
        SharedPreferences preferences = this.getSharedPreferences("user_data", MODE_PRIVATE);
        user_dni = preferences.getString("user_dni","0000000");
    }
    void GraficarZona(ZonaTrabajador.Zona zona){
        List<LatLng> polyline = new ArrayList<>();

        for(ZonaTrabajador.Zona.Coordenada coordenada: zona.getCoordenadas()){
            polyline.add( new LatLng(coordenada.getLatitud(),  coordenada.getLongitud()));
        }

        PolygonOptions polygonOptions = new PolygonOptions().addAll(polyline);
        polygonOptions.fillColor(this.getColor(R.color.colorZonas));
        mMap.addPolygon(polygonOptions);
    }
    public void ConexionRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getString(R.string.URL_Conection) + "Codigo/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        InterfazServicios interfazServicios = retrofit.create(InterfazServicios.class);
        Call<List<ZonaTrabajador>> listZonasTrabajador = interfazServicios.ConsultarZonas(user_dni);
        listZonasTrabajador.enqueue(new Callback<List<ZonaTrabajador>>() {
            @Override
            public void onResponse(Call<List<ZonaTrabajador>> call, Response<List<ZonaTrabajador>> response) {
                for(ZonaTrabajador zonaTrabajador : response.body()){
                    GraficarZona(zonaTrabajador.getZona());
                }
            }

            @Override
            public void onFailure(Call<List<ZonaTrabajador>> call, Throwable t) {
                Log.e("Error",t.toString());
            }
        });
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    1);
        }
        mMap = googleMap;
        mMap.setMyLocationEnabled(true);
        LatLng centroAqp = new LatLng(-16.3988032,-71.5390943);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centroAqp,13));
        ConexionRetrofit();
    }

}
