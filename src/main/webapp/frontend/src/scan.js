function AcquireImage() {
    var DWObject = Dynamsoft.WebTwainEnv.GetWebTwain('dwtcontrolContainer');
    if (DWObject) {
        DWObject.ProductKey = 't0112CQIAAC8jFf01Al+iBES8bNafd96NrrWNWFhSNGmOOcnl9Z6HTk+g+lwypAh39w7X4R9pw6O1iu39sQTAK8VW8yn0lRQE98cNs1OHDSOrXmWY/GMqf+biRZ0Y8CDbyIbJtiHzP4LZ7FGzjOIvT4Blxw==';
        DWObject.SelectSource(function () {
            var OnAcquireImageSuccess, OnAcquireImageFailure;
            OnAcquireImageSuccess = OnAcquireImageFailure = function () {
                DWObject.CloseSource();
            };
            DWObject.OpenSource();
            DWObject.IfShowUI = false; 
            DWObject.Resolution = 300;    
            DWObject.PixelType = EnumDWT_PixelType.TWPT_GRAY;
            DWObject.AcquireImage(OnAcquireImageSuccess, OnAcquireImageFailure);
        }, function () {
            console.log('SelectSource failed!');
        });
    }
}
