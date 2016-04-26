package polytech.unice.fr.polynews.fragment.info;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import polytech.unice.fr.polynews.R;

/**
 * @version on 22/04/16.
 */
public class GalleryFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_gallery, container, false);
        WebView web = (WebView) v.findViewById(R.id.webView_gallery);
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("file:///android_asset/gallery/with-jquery.html");
       // web.loadUrl("http://polytechsi3.wordpress.com");

        return v;
    }
}
