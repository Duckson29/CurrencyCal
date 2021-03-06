package dk.ducksoft.currencycal;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dk.ducksoft.currencycal.Models.CurrencyRate;

/**
 * Fixer.io.
 * Api key 97c8d6aed90c59590194a29d532fd44c;
 * first explme : http://data.fixer.io/api/latest?access_key=97c8d6aed90c59590194a29d532fd44c;
 * <p>
 * {
 * "success":true,
 * "timestamp":1605395351,
 * "base":"EUR",
 * "date":"2020-11-14",
 * "rates":{
 * "AED":4.347191,
 * "AFN":91.073875,
 * "ALL":124.039705,
 * "AMD":586.965267,
 * "ANG":2.125484,
 * "AOA":788.70632,
 * "ARS":94.366194,
 * "AUD":1.627844,
 * "AWG":2.130372,
 * "AZN":2.016717,
 * "BAM":1.959688,
 * "BBD":2.390807,
 * "BDT":100.454155,
 * "BGN":1.955777,
 * "BHD":0.446248,
 * "BIF":2296.067453,
 * "BMD":1.18354,
 * "BND":1.597144,
 * "BOB":8.164473,
 * "BRL":6.460358,
 * "BSD":1.184131,
 * "BTC":7.353802e-5,
 * "BTN":88.368162,
 * "BWP":13.259904,
 * "BYN":3.037981,
 * "BYR":23197.38251,
 * "BZD":2.386799,
 * "CAD":1.55522,
 * "CDF":2326.839919,
 * "CHF":1.080479,
 * "CLF":0.032903,
 * "CLP":907.898106,
 * "CNY":7.818943,
 * "COP":4309.860633,
 * "CRC":727.131435,
 * "CUC":1.18354,
 * "CUP":31.363808,
 * "CVE":110.547241,
 * "CZK":26.429043,
 * "DJF":210.339181,
 * "DKK":7.450862,
 * "DOP":69.190209,
 * "DZD":152.677075,
 * "EGP":18.507999,
 * "ERN":17.753523,
 * "ETB":44.679096,
 * "EUR":1,
 * "FJD":2.488398,
 * "FKP":0.896992,
 * "GBP":0.896961,
 * "GEL":3.894309,
 * "GGP":0.896992,
 * "GHS":6.912335,
 * "GIP":0.896992,
 * "GMD":61.295994,
 * "GNF":11545.432379,
 * "GTQ":9.215341,
 * "GYD":247.376988,
 * "HKD":9.176582,
 * "HNL":28.764566,
 * "HRK":7.573003,
 * "HTG":75.842304,
 * "HUF":357.500528,
 * "IDR":16760.998893,
 * "ILS":3.986404,
 * "IMP":0.896992,
 * "INR":88.218585,
 * "IQD":1408.41251,
 * "IRR":49832.948917,
 * "ISK":161.612833,
 * "JEP":0.896992,
 * "JMD":175.326148,
 * "JOD":0.839177,
 * "JPY":123.907209,
 * "KES":129.302192,
 * "KGS":100.368685,
 * "KHR":4811.090206,
 * "KMF":492.530594,
 * "KPW":1065.185963,
 * "KRW":1312.101995,
 * "KWD":0.361813,
 * "KYD":0.986542,
 * "KZT":509.212439,
 * "LAK":10983.250908,
 * "LBP":1789.999885,
 * "LKR":218.646128,
 * "LRD":188.18326,
 * "LSL":18.357156,
 * "LTL":3.494686,
 * "LVL":0.715912,
 * "LYD":1.603743,
 * "MAD":10.80617,
 * "MDL":20.272008,
 * "MGA":4674.98311,
 * "MKD":61.727129,
 * "MMK":1533.42481,
 * "MNT":3378.853509,
 * "MOP":9.457017,
 * "MRO":422.524362,
 * "MUR":47.164514,
 * "MVR":18.230943,
 * "MWK":901.857831,
 * "MXN":24.150965,
 * "MYR":4.880332,
 * "MZN":87.019819,
 * "NAD":18.357151,
 * "NGN":450.341352,
 * "NIO":41.276001,
 * "NOK":10.852237,
 * "NPR":141.38934,
 * "NZD":1.729609,
 * "OMR":0.455634,
 * "PAB":1.18383,
 * "PEN":4.312232,
 * "PGK":4.148353,
 * "PHP":57.028917,
 * "PKR":187.443181,
 * "PLN":4.483356,
 * "PYG":8326.992569,
 * "QAR":4.309314,
 * "RON":4.86968,
 * "RSD":117.573298,
 * "RUB":91.492003,
 * "RWF":1156.910276,
 * "SAR":4.438969,
 * "SBD":9.588977,
 * "SCR":24.677248,
 * "SDG":65.454111,
 * "SEK":10.286505,
 * "SGD":1.59572,
 * "SHP":0.896992,
 * "SLL":11823.564242,
 * "SOS":690.004176,
 * "SRD":16.751869,
 * "STD":24892.100448,
 * "SVC":10.358392,
 * "SYP":607.09378,
 * "SZL":18.357142,
 * "THB":35.696001,
 * "TJS":13.413005,
 * "TMT":4.154225,
 * "TND":3.255331,
 * "TOP":2.72337,
 * "TRY":9.068879,
 * "TTD":8.034417,
 * "TWD":33.735193,
 * "TZS":2744.629481,
 * "UAH":33.296047,
 * "UGX":4375.313269,
 * "USD":1.18354,
 * "UYU":50.673757,
 * "UZS":12285.144807,
 * "VEF":11.82061,
 * "VND":27429.721279,
 * "VUV":132.378685,
 * "WST":3.114667,
 * "XAF":657.250868,
 * "XAG":0.047958,
 * "XAU":0.000627,
 * "XCD":3.198576,
 * "XDR":0.834443,
 * "XOF":656.865051,
 * "XPF":119.896855,
 * "YER":296.244301,
 * "ZAR":18.351869,
 * "ZMK":10653.283816,
 * "ZMW":24.753831,
 * "ZWL":381.099786
 * }
 * }
 */

public class WebApiCaller  {


    private ArrayList<CurrencyRate> rates = new ArrayList<>();

    /**
     * This is the opserverable side of the patten.
     * evey ohter thing that wants to opserve something needs to "Subscripe to this list".
     * */
    private ArrayList<OnJsonRespon> listeners = new ArrayList<>();

    /**
     * The opserver "subsrcipe" to this list to be "notifiy" of change.
     * */
    public void addListener(OnJsonRespon listener) {
        listeners.add(listener);
    }

    /**
     * as a opserver need to be able to "Unscripe" from the list.
     * */
    public void removeListener(OnJsonRespon listener) {
        listeners.remove(listener);
    }

    public void GetNewCurrencyRate(Context activity) {
        String urlReel = "http://data.fixer.io/api/latest?access_key=97c8d6aed90c59590194a29d532fd44c";
        String url = "https://jsonplaceholder.typicode.com/todos/2";

        // the api call that gets all the current currency rates.
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.POST, urlReel, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject ar = response.getJSONObject("rates");
                            Iterator<String> s = ar.keys();

                            for (int i = 0; i < ar.length(); i++) {
                                String tempKey = s.next();
                                rates.add(new CurrencyRate(tempKey,ar.getDouble(tempKey),i));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        for (OnJsonRespon listeners: listeners) {
                            listeners.OnDataRecived(rates);
                        }
                    }
                },new Response.ErrorListener() {

                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.e("Web",error.getMessage());
                            }
                        });
        /*
        * it only fires when added to requsestQuesu.
        * */
        Volley.newRequestQueue(activity).add(jsonObjectRequest);

    }


}
