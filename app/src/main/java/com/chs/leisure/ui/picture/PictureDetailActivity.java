package com.chs.leisure.ui.picture;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.chs.leisure.Constant;
import com.chs.leisure.R;
import com.chs.leisure.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者：chs on 2016/4/26 17:47
 * 邮箱：657083984@qq.com
 */
public class PictureDetailActivity extends BaseActivity {
    @Bind(R.id.web_view)
    WebView webView;
    @Bind(R.id.pb_bar)
    ProgressBar progressBar;
    @Bind(R.id.rl_content)
    FrameLayout rl_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        int id = getIntent().getIntExtra("id",1);
        String url = Constant.PIC_WEB+id;
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setAppCacheEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setSupportZoom(true);
        webView.loadUrl(url);
//        webView.setWebChromeClient(new ChromeClient());
        webView.setWebViewClient(new PicClient());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (webView != null) {
            rl_content.removeView(webView);
            webView.removeAllViews();
            webView.destroy();
            webView = null;
        }
    }
//    private class ChromeClient extends WebChromeClient {
//        @Override
//        public void onProgressChanged(WebView view, int newProgress) {
//            super.onProgressChanged(view, newProgress);
//            iView.showProgressBar(newProgress);
//        }
//
//        @Override
//        public void onReceivedTitle(WebView view, String title) {
//            super.onReceivedTitle(view, title);
//            iView.setWebTitle(title);
//        }
//    }

    private class PicClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url != null) view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            if(progressBar!=null){
                progressBar.setVisibility(View.GONE);
            }
        }
    }
}
