package unii.other.business.card.makeup;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Gallery;

import unii.other.business.card.makeup.databinding.ActivityBusinessCardBinding;
import unii.other.business.card.makeup.databinding.ContentBusinessCardBinding;
import unii.other.business.card.makeup.model.BusinessCardViewModel;
import unii.other.business.card.makeup.presenter.GalleryAdapter;

import static unii.other.business.card.makeup.model.BusinessCardViewModel.PERMISSION_PHONE_CALL;

/**
 * Icon credit:
 * <div>Icons made by <a href="https://www.flaticon.com/authors/roundicons" title="Roundicons">Roundicons</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a></div>
 */
public class BusinessCardActivity extends AppCompatActivity {
    BusinessCardViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBusinessCardBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_business_card);
        viewModel = new BusinessCardViewModel(this);
        binding.setViewModel(viewModel);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);


        Gallery simpleGallery = (Gallery) findViewById(R.id.modelGallery);
        GalleryAdapter adapter = new GalleryAdapter(this, viewModel.getGalleryImages());
        simpleGallery.setAdapter(adapter);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_PHONE_CALL:
                if (PackageManager.PERMISSION_GRANTED == grantResults[0] && viewModel != null) {
                    viewModel.onCallClicked(null);
                }
        }
    }

}
