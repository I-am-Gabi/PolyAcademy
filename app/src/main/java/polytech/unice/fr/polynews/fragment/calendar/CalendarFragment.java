package polytech.unice.fr.polynews.fragment.calendar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import polytech.unice.fr.polynews.R;

public class CalendarFragment extends Fragment {
    private static final String calendar_html = "<iframe src=\"https://calendar.google.com/calendar/embed?src=maau4h69jhjvsl7a1g3nhqch20%40group.calendar.google.com&ctz=Europe/Paris\" style=\"border: 0\" width=\"800\" height=\"600\" frameborder=\"0\" scrolling=\"no\"></iframe>";

    public static CalendarFragment newInstance() {
        CalendarFragment fragment = new CalendarFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_calendar,container,false);
        WebView calendar = (WebView) v.findViewById(R.id.webview_calendar);
        calendar.setInitialScale(1);
        calendar.setWebChromeClient(new WebChromeClient());
        calendar.getSettings().setAllowFileAccess(true);
        calendar.getSettings().setPluginState(WebSettings.PluginState.ON);
        calendar.getSettings().setPluginState(WebSettings.PluginState.ON_DEMAND);
        calendar.setWebViewClient(new WebViewClient());
        calendar.getSettings().setJavaScriptEnabled(true);
        calendar.getSettings().setLoadWithOverviewMode(true);
        calendar.getSettings().setUseWideViewPort(true);

        calendar.getSettings().setJavaScriptEnabled(true);
        calendar.loadData(calendar_html, "text/html", null);

        return v;
    }
}
