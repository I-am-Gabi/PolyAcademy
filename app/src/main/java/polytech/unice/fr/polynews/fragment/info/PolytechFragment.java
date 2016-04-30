package polytech.unice.fr.polynews.fragment.info;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import java.util.Locale;

import polytech.unice.fr.polynews.R;

/**
 * @version 20/04/16.
 */
public class PolytechFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.about_polytech, container, false);
        WebView header = (WebView) v.findViewById(R.id.webView_header);
        header.getSettings().setJavaScriptEnabled(true);
        header.loadUrl("file:///android_asset/gallery/with-jquery.html");

        WebView about_si = (WebView) v.findViewById(R.id.about_si);
        //if (Locale.getDefault().getLanguage() == "fr"){
            about_si.loadUrl("file:///android_asset/polytech_si3/about_si-fr.html");
       // }

        return v;
    }
}