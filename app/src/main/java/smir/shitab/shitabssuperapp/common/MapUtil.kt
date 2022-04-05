
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng

class MapUtil {
  
  private lateinit var mMap: GoogleMap

  companion object {
    
    fun setupMapView(location: GeoPoint) {
        //val mapFragment = childFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        //mapFragment.getMapAsync(OnMapReadyCallback {
          //  mMap = it

            //mMap.mapType = GoogleMap.MAP_TYPE_NORMAL

            //mMap.uiSettings.isCompassEnabled = false
            //mMap.uiSettings.isMyLocationButtonEnabled = false
            //mMap.uiSettings.isMapToolbarEnabled = false
            //mMap.uiSettings.isScrollGesturesEnabled = false

            //mMap.setMinZoomPreference(16f)
            //val latLng = LatLng(location.lat, location.lng)
            //mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng))


        })
    }
  }
}
