package rohksin.com.olaplay.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import rohksin.com.olaplay.R;

/**
 * Created by Illuminati on 12/17/2017.
 */

public class DevelperProfileActivity extends AppCompatActivity {


    @BindView(R.id.linkedIn)
    CircleImageView linkedin;

    @BindView(R.id.github)
    CircleImageView github;

    @BindView(R.id.googlePlay)
    CircleImageView playstore;

    @BindView(R.id.gmail)
    CircleImageView gmail;

    @BindView(R.id.stackoerflow)
    CircleImageView stackoverflow;

    private String linkedInLink="https://www.linkedin.com/in/rohit-singh-50a110105/";
    private String gitHubLink ="https://github.com/rohitksingh";
    private String stackoverflowLink ="https://stackoverflow.com/users/4700156/rohit-singh?tab=profile";
    private String playStoreLink = "https://play.google.com/store/apps/details?id=com.omdb.rohksin.omdb&hl=en";
    private String gmailId ="r4rohit002@gmail.com";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dev_profile);
        ButterKnife.bind(this);


        stackoverflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLinkWithBrowser(stackoverflowLink);
            }
        });

        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLinkWithBrowser(gitHubLink);
            }
        });

        playstore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLinkWithBrowser(playStoreLink);
            }
        });

        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLinkWithBrowser(linkedInLink);
            }
        });

        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 openGmail();
            }
        });
    }

    private void openLinkWithBrowser(String url){

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    private void openGmail(){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto",gmailId, null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Body");
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }

}
