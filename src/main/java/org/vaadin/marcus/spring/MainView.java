package org.vaadin.marcus.spring;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
@JavaScript("https://tst.dynamsoft.com/libs/dwt/14.3.1/dynamsoft.webtwain.min.js")
public class MainView extends VerticalLayout {
  public MainView() {
    Button addButton = new Button("Scan");

    addButton.addClickListener(click -> {
      String acquireimage = "var DWObject = Dynamsoft.WebTwainEnv.GetWebTwain('dwtcontrolContainer');DWObject.ProductKey = 't0112CQIAAC8jFf01Al+iBES8bNafd96NrrWNWFhSNGmOOcnl9Z6HTk+g+lwypAh39w7X4R9pw6O1iu39sQTAK8VW8yn0lRQE98cNs1OHDSOrXmWY/GMqf+biRZ0Y8CDbyIbJtiHzP4LZ7FGzjOIvT4Blxw==';if (DWObject) {DWObject.SelectSource(function () {var OnAcquireImageSuccess, OnAcquireImageFailure;OnAcquireImageSuccess = OnAcquireImageFailure = function () {DWObject.CloseSource();};DWObject.OpenSource();DWObject.IfShowUI = false; DWObject.Resolution = 300;    DWObject.PixelType = EnumDWT_PixelType.TWPT_GRAY;DWObject.AcquireImage(OnAcquireImageSuccess, OnAcquireImageFailure);}, function () {console.log('SelectSource failed!');});}";
      getUI().get().getPage().executeJavaScript(acquireimage);

    });

    add(new H1("Vaadin Dynamic Web TWAIN"), new VerticalLayout(addButton, new WebTWAINContainer()));
  }

  @Tag("div")
  public static class WebTWAINContainer extends Component {
    public WebTWAINContainer() {
      getElement().setProperty("id", "dwtcontrolContainer");
    }

  }

}
