package unii.other.business.card.makeup.repository;


import android.content.Context;

import unii.other.business.card.makeup.R;

public final class BusinessCardRepository {

    public BusinessCardRepository(Context context) {
        phoneCallUri = context.getString(R.string.intent_uri_call);
        emailAddress = context.getString(R.string.email_address);
        emailTitle = context.getString(R.string.email_title);
    }

    private String phoneCallUri;
    private String emailAddress;
    private String emailTitle;
    private int[] images = {R.drawable.model1, R.drawable.model2, R.drawable.model3, R.drawable.model4, R.drawable.model5, R.drawable.model6};// ,R.drawable.model2, R.drawable.model3, R.drawable.model4, R.drawable.model5, R.drawable.model6

    public String getPhoneCallUri() {
        return phoneCallUri;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getEmailTitle() {
        return emailTitle;
    }

    public int[] getGalleryImages() {
        return images;
    }

}
