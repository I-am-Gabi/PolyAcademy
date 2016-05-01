package polytech.unice.fr.polynews.fragment.news;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import polytech.unice.fr.polynews.R;
import polytech.unice.fr.polynews.activity.DownloadPictures;

/**
 * A fragment representing a single Item detail screen.
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_TITLE = "item_title";
    public static final String ARG_ITEM_CONTENT = "item_content";
    public static final String ARG_ITEM_MEDIA_PATH = "item_media_path";


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_TITLE)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            //mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout_new);
            if (appBarLayout != null) {
                appBarLayout.setTitle(getArguments().getString(ARG_ITEM_TITLE));
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);

        DownloadPictures task = new DownloadPictures((ImageView) rootView.findViewById(R.id.image_new_detail), container.getContext());
        task.execute(getArguments().getString(ARG_ITEM_MEDIA_PATH));

        ((TextView) rootView.findViewById(R.id.item_detail)).setText(getArguments().getString(ARG_ITEM_CONTENT));
        return rootView;
    }
}
