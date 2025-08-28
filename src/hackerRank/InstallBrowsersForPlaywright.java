package hackerRank;

import com.microsoft.playwright.CLI;

import java.io.IOException;

public class InstallBrowsersForPlaywright {

    public static void main(String[] args) throws IOException, InterruptedException {
        CLI.main(new String[]{"install"});
    }

}
