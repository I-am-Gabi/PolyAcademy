package polytech.unice.fr.polynews.fragment.calendar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import polytech.unice.fr.polynews.R;

public class CalendarFragment extends Fragment {

    public static CalendarFragment newInstance() {
        CalendarFragment fragment = new CalendarFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.layout_calendar,container,false);
        WebView calendar = (WebView) v.findViewById(R.id.webview_calendar);
        calendar.getSettings().setJavaScriptEnabled(true);
        calendar.loadUrl("https://calendar.google.com/calendar/embed?src=maau4h69jhjvsl7a1g3nhqch20%40group.calendar.google.com&ctz=Europe/Paris");
        return v;
    }
}
