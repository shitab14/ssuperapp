
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import smir.shitab.shitabssuperapp.R

class MapUtil {

  companion object {

    private lateinit var mMap: GoogleMap

    fun setupMapView(lat: Double, lng: Double, parentFragment: Fragment, mapFragment: SupportMapFragment) {
//        val mapFragment = parentFragment.childFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(OnMapReadyCallback {
            mMap = it

            mMap.mapType = GoogleMap.MAP_TYPE_NORMAL

            mMap.uiSettings.isCompassEnabled = false
            mMap.uiSettings.isMyLocationButtonEnabled = false
            mMap.uiSettings.isMapToolbarEnabled = false
            mMap.uiSettings.isScrollGesturesEnabled = false

            mMap.setMinZoomPreference(16f)
            val latLng = LatLng(lat, lng)
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng))


        })
    }
  }
}
