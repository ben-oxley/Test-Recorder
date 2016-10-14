package uk.co.benoxley.recorder.ui.main;

import com.airhacks.afterburner.views.FXMLView;

/**
 * Created by ben on 14/10/2016.
 */
public class MainView  extends FXMLView {
    @Override
    public MainPresenter getPresenter() {
        return (MainPresenter) super.getPresenter();
    }
}
