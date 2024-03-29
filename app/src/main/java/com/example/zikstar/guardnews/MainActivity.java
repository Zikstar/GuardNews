package com.example.zikstar.guardnews;


import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.material.tabs.TabLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import com.example.zikstar.guardnews.Fragments.IsaacFragmentPagerAdapter;

public class MainActivity extends AppCompatActivity {
    //Android admob id : ca-app-pub-9279612931361469~5701232367

    public static final String LOG_TAG = "LogMan";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        IsaacFragmentPagerAdapter adapter = new IsaacFragmentPagerAdapter(getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

//    private static final String GUARDIANURL = "https://content.guardianapis.com/football?api-key=test&show-fields=thumbnail";
//            //"https://content.guardianapis.com/search?q=football&api-key=test&show-fields=thumbnail";
//    //search instead of sections
//    //"https://content.guardianapis.com/search?q=football&api-key=fa42ecfe-4fbc-4ac6-bad1-ba42e710c56c&show-fields=thumbnail"
//
//    private String exampleJson = "\"pageSize\":10,\"currentPage\":1,\"pages\":2556,\"orderBy\":\"relevance\",\"results\":[{\"id\":\"politics/2018/sep/17/election-debates-commission-needed-says-sky-news\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2018-09-16T23:01:06Z\",\"webTitle\":\"Election debates commission needed, says Sky News\",\"webUrl\":\"https://www.theguardian.com/politics/2018/sep/17/election-debates-commission-needed-says-sky-news\",\"apiUrl\":\"https://content.guardianapis.com/politics/2018/sep/17/election-debates-commission-needed-says-sky-news\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"australia-news/2018/nov/26/tobacco-gambling-and-alcohol-donations-rise-during-critical-debates\",\"type\":\"article\",\"sectionId\":\"australia-news\",\"sectionName\":\"Australia news\",\"webPublicationDate\":\"2018-11-26T17:00:45Z\",\"webTitle\":\"Tobacco, gambling and alcohol donations 'rise during critical debates'\",\"webUrl\":\"https://www.theguardian.com/australia-news/2018/nov/26/tobacco-gambling-and-alcohol-donations-rise-during-critical-debates\",\"apiUrl\":\"https://content.guardianapis.com/australia-news/2018/nov/26/tobacco-gambling-and-alcohol-donations-rise-during-critical-debates\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"australia-news/2018/aug/13/turnbulls-energy-policy-hangs-in-the-balance-as-euthanasia-debate-given-precedence\",\"type\":\"article\",\"sectionId\":\"australia-news\",\"sectionName\":\"Australia news\",\"webPublicationDate\":\"2018-08-12T18:00:08Z\",\"webTitle\":\"Energy policy hangs in balance, as Senate debates euthanasia\",\"webUrl\":\"https://www.theguardian.com/australia-news/2018/aug/13/turnbulls-energy-policy-hangs-in-the-balance-as-euthanasia-debate-given-precedence\",\"apiUrl\":\"https://content.guardianapis.com/australia-news/2018/aug/13/turnbulls-energy-policy-hangs-in-the-balance-as-euthanasia-debate-given-precedence\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"politics/2018/dec/01/may-v-corbyn-on-brexit-the-debate-over-the-debate\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2018-12-01T07:00:15Z\",\"webTitle\":\"May v Corbyn on Brexit: the debate over the debate\",\"webUrl\":\"https://www.theguardian.com/politics/2018/dec/01/may-v-corbyn-on-brexit-the-debate-over-the-debate\",\"apiUrl\":\"https://content.guardianapis.com/politics/2018/dec/01/may-v-corbyn-on-brexit-the-debate-over-the-debate\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"politics/2018/dec/04/bbc-itv-plan-rival-brexit-debates-corbyn-may-cant-agree-format\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2018-12-04T10:17:38Z\",\"webTitle\":\"Rival Brexit debates planned as Corbyn and May can't agree on format\",\"webUrl\":\"https://www.theguardian.com/politics/2018/dec/04/bbc-itv-plan-rival-brexit-debates-corbyn-may-cant-agree-format\",\"apiUrl\":\"https://content.guardianapis.com/politics/2018/dec/04/bbc-itv-plan-rival-brexit-debates-corbyn-may-cant-agree-format\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"australia-news/2018/nov/22/not-a-soft-on-crime-option-nsw-debates-plan-for-indigenous-sentencing-court\",\"type\":\"article\",\"sectionId\":\"australia-news\",\"sectionName\":\"Australia news\",\"webPublicationDate\":\"2018-11-21T17:00:16Z\",\"webTitle\":\"'Not a soft-on-crime option': NSW debates plan for Indigenous sentencing court\",\"webUrl\":\"https://www.theguardian.com/australia-news/2018/nov/22/not-a-soft-on-crime-option-nsw-debates-plan-for-indigenous-sentencing-court\",\"apiUrl\":\"https://content.guardianapis.com/australia-news/2018/nov/22/not-a-soft-on-crime-option-nsw-debates-plan-for-indigenous-sentencing-court\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"world/2018/nov/06/canada-debates-assisted-death-laws\",\"type\":\"article\",\"sectionId\":\"world\",\"sectionName\":\"World news\",\"webPublicationDate\":\"2018-11-06T10:00:27Z\",\"webTitle\":\"Canada debates assisted death laws after woman is forced to end life early\",\"webUrl\":\"https://www.theguardian.com/world/2018/nov/06/canada-debates-assisted-death-laws\",\"apiUrl\":\"https://content.guardianapis.com/world/2018/nov/06/canada-debates-assisted-death-laws\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"media/2018/jun/13/the-rev-colin-morris-obituary-letter\",\"type\":\"article\",\"sectionId\":\"media\",\"sectionName\":\"Media\",\"webPublicationDate\":\"2018-06-13T15:00:17Z\",\"webTitle\":\"Letter: Invoking the Rev Colin Morris law of TV debates\",\"webUrl\":\"https://www.theguardian.com/media/2018/jun/13/the-rev-colin-morris-obituary-letter\",\"apiUrl\":\"https://content.guardianapis.com/media/2018/jun/13/the-rev-colin-morris-obituary-letter\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"politics/2018/may/10/tories-accused-of-subverting-democracy-by-not-tabling-brexit-debates\",\"type\":\"article\",\"sectionId\":\"politics\",\"sectionName\":\"Politics\",\"webPublicationDate\":\"2018-05-10T16:09:05Z\",\"webTitle\":\"Tories accused of 'subverting democracy' by not tabling Brexit debates\",\"webUrl\":\"https://www.theguardian.com/politics/2018/may/10/tories-accused-of-subverting-democracy-by-not-tabling-brexit-debates\",\"apiUrl\":\"https://content.guardianapis.com/politics/2018/may/10/tories-accused-of-subverting-democracy-by-not-tabling-brexit-debates\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"},{\"id\":\"world/2018/may/04/project-fantasy-german-exam-question-debates-brexit-reality\",\"type\":\"article\",\"sectionId\":\"world\",\"sectionName\":\"World news\",\"webPublicationDate\":\"2018-05-04T15:19:29Z\",\"webTitle\":\"Project Fantasy? German exam question debates Brexit reality\",\"webUrl\":\"https://www.theguardian.com/world/2018/may/04/project-fantasy-german-exam-question-debates-brexit-reality\",\"apiUrl\":\"https://content.guardianapis.com/world/2018/may/04/project-fantasy-german-exam-question-debates-brexit-reality\",\"isHosted\":false,\"pillarId\":\"pillar/news\",\"pillarName\":\"News\"}]}}";
//

}
