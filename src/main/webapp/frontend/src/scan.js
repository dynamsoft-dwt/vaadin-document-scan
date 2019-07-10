function AcquireImage() {
    var DWObject = Dynamsoft.WebTwainEnv.GetWebTwain('dwtcontrolContainer');
    if (DWObject) {
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

function loadDWT() {
    /**
     * Add your valid product key here if you 
     * Dynamsoft.WebTwainEnv.ProductKey = ""; 
     */
    Dynamsoft.WebTwainEnv.Load();
}