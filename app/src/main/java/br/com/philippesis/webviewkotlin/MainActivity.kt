package br.com.philippesis.webviewkotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView = findViewById<WebView>(R.id.webview)

        val unencodedHtml = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title>chart created with amCharts | amCharts</title>\n" +
                "<meta name=\"description\" content=\"chart created using amCharts live editor\" />\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "    <!-- Styles -->\n" +
                "    <style>\n" +
                "    #chartdiv {\n" +
                "    width: 100%;\n" +
                "    height: 500px;\n" +
                "    }\n" +
                "\n" +
                "    </style>\n" +
                "\n" +
                "    <!-- Resources -->\n" +
                "    <script type = \"text/javascript\" src=\"file:///android_asset/amcharts/lib/4/core.js\"></script>\n" +
                "    <script type = \"text/javascript\" src=\"file:///android_asset/amcharts/lib/4/charts.js\"></script>\n" +
                "    <script type = \"text/javascript\" src=\"file:///android_asset/amcharts/lib/4/themes/animated.js\"></script>\n" +
                "\n" +
                "    <!-- Chart code -->\n" +
                "    <script>\n" +
                "    am4core.ready(function() {\n" +
                "\n" +
                "    // Themes begin\n" +
                "    am4core.useTheme(am4themes_animated);\n" +
                "    // Themes end\n" +
                "\n" +
                "    // Create chart instance\n" +
                "    var chart = am4core.create(\"chartdiv\", am4charts.XYChart);\n" +
                "\n" +
                "    // Add data\n" +
                "    chart.data = [{\n" +
                "    \"country\": \"USA\",\n" +
                "    \"visits\": 2025\n" +
                "    }, {\n" +
                "    \"country\": \"Japan\",\n" +
                "    \"visits\": 1809\n" +
                "    }, {\n" +
                "    \"country\": \"Germany\",\n" +
                "    \"visits\": 1322\n" +
                "    }, {\n" +
                "    \"country\": \"UK\",\n" +
                "    \"visits\": 1122\n" +
                "    }, {\n" +
                "    \"country\": \"India\",\n" +
                "    \"visits\": 984\n" +
                "    }, {\n" +
                "    \"country\": \"Spain\",\n" +
                "    \"visits\": 711\n" +
                "    }, {\n" +
                "    \"country\": \"Russia\",\n" +
                "    \"visits\": 580\n" +
                "    }, {\n" +
                "    \"country\": \"Brazil\",\n" +
                "    \"visits\": 395\n" +
                "    }];\n" +
                "\n" +
                "    // Create axes\n" +
                "\n" +
                "    var categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());\n" +
                "    categoryAxis.dataFields.category = \"country\";\n" +
                "    categoryAxis.renderer.grid.template.location = 0;\n" +
                "    categoryAxis.renderer.minGridDistance = 30;\n" +
                "\n" +
                "    categoryAxis.renderer.labels.template.adapter.add(\"dy\", function(dy, target) {\n" +
                "    if (target.dataItem && target.dataItem.index & 2 == 2) {\n" +
                "        return dy + 25;\n" +
                "    }\n" +
                "    return dy;\n" +
                "    });\n" +
                "\n" +
                "    var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());\n" +
                "\n" +
                "    // Create series\n" +
                "    var series = chart.series.push(new am4charts.ColumnSeries());\n" +
                "    series.dataFields.valueY = \"visits\";\n" +
                "    series.dataFields.categoryX = \"country\";\n" +
                "    series.name = \"Visits\";\n" +
                "    series.columns.template.tooltipText = \"{categoryX}: [bold]{valueY}[/]\";\n" +
                "    series.columns.template.fillOpacity = .8;\n" +
                "\n" +
                "    var columnTemplate = series.columns.template;\n" +
                "    columnTemplate.strokeWidth = 2;\n" +
                "    columnTemplate.strokeOpacity = 1;\n" +
                "\n" +
                "    }); // end am4core.ready()\n" +
                "    </script>\n" +
                "\n" +
                "    <!-- HTML -->\n" +
                "    <div id=\"chartdiv\"></div>\n" +
                "\n" +
                "</body>\n" +
                "</html>"

        webView.settings.javaScriptEnabled = true

        webView.loadDataWithBaseURL("file:///android_asset", unencodedHtml, "text/html", "UTF-8", null)

    }
}
