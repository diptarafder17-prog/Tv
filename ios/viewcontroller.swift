import UIKit
import WebKit

class ViewController: UIViewController, WKNavigationDelegate {
  var webView: WKWebView!
  // Replace with your hosted landing page URL after publishing the site
  let landing = URL(string: "https://yourusername.github.io/open-live-tv/")!

  override func loadView() {
    webView = WKWebView()
    webView.navigationDelegate = self
    view = webView
  }

  override func viewDidLoad() {
    super.viewDidLoad()
    webView.allowsBackForwardNavigationGestures = true
    webView.load(URLRequest(url: landing))
  }
}
