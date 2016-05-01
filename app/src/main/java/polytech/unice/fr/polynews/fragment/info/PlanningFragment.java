package polytech.unice.fr.polynews.fragment.info;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import polytech.unice.fr.polynews.R;


/**
 * @version 20/04/16.
 */
public class PlanningFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.planning, container, false);
        WebView web = (WebView) v.findViewById(R.id.planning_webView);
        web.loadUrl("file:///android_asset/planning/index.html");
        return v;
    }
}
