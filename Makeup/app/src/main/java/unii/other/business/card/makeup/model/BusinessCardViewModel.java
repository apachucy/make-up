package unii.other.business.card.makeup.model;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.View;

import unii.other.business.card.makeup.R;
import unii.other.business.card.makeup.repository.BusinessCardRepository;

public class BusinessCardViewModel {
    private Context context;
    private BusinessCardRepository businessCardRepository;
    public static final int PERMISSION_PHONE_CALL = 1;

    public BusinessCardViewModel(Context context) {
        this.context = context;
        this.businessCardRepository = new BusinessCardRepository(context);
    }

    public void onCallClicked(View view) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse(businessCardRepository.getPhoneCallUri()));
        if (ActivityCompat.checkSelfPermission(context,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context,
                    new String[]{Manifest.permission.CALL_PHONE},
                    PERMISSION_PHONE_CALL);
            return;
        }

        context.startActivity(callIntent);

    }


    public void onEmailClicked(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse(context.getString(R.string.intent_email_action))); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{businessCardRepository.getEmailAddress()});
        intent.putExtra(Intent.EXTRA_SUBJECT, businessCardRepository.getEmailTitle());
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }

    public void onFaceBookClicked(View view) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(context.getString(R.string.intent_uri_www)));
        context.startActivity(i);
    }

    public int[] getGalleryImages() {
        return businessCardRepository.getGalleryImages();
    }
}
