package com.example.kikishop.ui.dashboard;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.kikishop.data.db.DataBaseResults;
import com.example.kikishop.databinding.FragmentDashboardBinding;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(com.example.kikishop.ui.dashboard.DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // set graphs
        setBarChart(binding, dashboardViewModel);
        setPieChart(binding);
        setRadarData(binding);



        dashboardViewModel.getItemsValue().observe(getViewLifecycleOwner(), new Observer<ArrayList<BarEntry>>() {
            @Override
            public void onChanged(ArrayList<BarEntry> entries) {
                BarDataSet dataSet = new BarDataSet(entries, "Dane");
                dataSet.setColors(dashboardViewModel.getItemsColor());  // pobierasz kolory z ViewModelu

                BarData data = new BarData(dataSet);
                binding.barChart.setData(data);
                binding.barChart.invalidate();
            }
        });


        final TextView textView = binding.textDashboard;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void setBarChart(FragmentDashboardBinding binding, DashboardViewModel dashboardViewModel) {
        HorizontalBarChart barChart = binding.barChart;

        dashboardViewModel.setItemsName(new MutableLiveData<>(DataBaseResults.getInstance().getItemsName()));
        dashboardViewModel.setItemsValue(new MutableLiveData<>(DataBaseResults.getInstance().getItemsValue()));

        DataBaseResults results = DataBaseResults.getInstance();
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(results.getItemsName()));
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);
        xAxis.setDrawGridLines(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);

        MutableLiveData<String[]> itemsNameLiveData = new MutableLiveData<>();
        itemsNameLiveData.setValue(results.getItemsName());
        dashboardViewModel.setItemsName(itemsNameLiveData);

        MutableLiveData<ArrayList<BarEntry>> itemsLiveData = new MutableLiveData<>();
        itemsLiveData.setValue(results.getItemsValue());
        dashboardViewModel.setItemsValue(itemsLiveData);


        dashboardViewModel.setItemsValue(itemsLiveData);


        dashboardViewModel.getItems().observe(getViewLifecycleOwner(), new Observer<Integer[]>() {
            @Override
            public void onChanged(Integer[] integers) {
            }
        });
    }
    public void setPieChart(FragmentDashboardBinding binding) {
        PieChart chart = binding.piChart;

        chart.setUsePercentValues(true); // wartości w procentach
        chart.getDescription().setEnabled(false); // wyłącz opis
        chart.setExtraOffsets(5, 10, 5, 5);

        chart.setDragDecelerationFrictionCoef(0.95f);

        chart.setDrawHoleEnabled(true);
        chart.setHoleColor(Color.WHITE);
        chart.setHoleRadius(45f); // %
        chart.setTransparentCircleRadius(50f);

        chart.setCenterText("Sprzedaż\nQ1");
        chart.setCenterTextSize(14f);
        chart.setCenterTextTypeface(Typeface.DEFAULT_BOLD);

        chart.setRotationAngle(0);
        chart.setRotationEnabled(true);
        chart.setHighlightPerTapEnabled(true);

        // legenda
        chart.getLegend().setEnabled(true);
        chart.getLegend().setTextSize(12f);
        chart.getLegend().setWordWrapEnabled(true); // zawijaj legendę

        // etykiety wpisów (wartości) ustawienia
        chart.setEntryLabelColor(Color.BLACK);
        chart.setEntryLabelTextSize(12f);
        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(40f, "Produkty A"));
        entries.add(new PieEntry(25f, "Produkty B"));
        entries.add(new PieEntry(20f, "Produkty C"));
        entries.add(new PieEntry(15f, "Produkty D"));
        PieDataSet dataSet = new PieDataSet(entries, "Kategorie");

        // style słupków (slice)
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(8f); // shift po dotknięciu

        // kolory - możesz użyć gotowych palet lub własnych
        List<Integer> colors = new ArrayList<>();
        // przykładowe: mieszanka ColorTemplate
        for (int c : ColorTemplate.MATERIAL_COLORS) colors.add(c);
        for (int c : ColorTemplate.COLORFUL_COLORS) colors.add(c);
        // albo własne z zasobów:
        // colors.add(ContextCompat.getColor(requireContext(), R.color.myColor));

        dataSet.setColors(colors);

        // wartości pokazane jako procenty
        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter(chart)); // procenty
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.WHITE);

        chart.setData(data);
        chart.invalidate(); // odśwież
        chart.animateY(1000); // animacja
    }
    public void setRadarData(FragmentDashboardBinding binding){
        RadarChart chart = binding.radarChart;

        chart.getDescription().setEnabled(false);
        chart.setWebLineWidth(2f);
        chart.setWebColor(Color.LTGRAY);
        chart.setWebLineWidthInner(2f);
        chart.setWebColorInner(Color.LTGRAY);
        chart.setWebAlpha(100);
        chart.setExtraOffsets(0,0,0,0);
        // X axis labels (categories around the radar)
        XAxis xAxis = chart.getXAxis();
        xAxis.setTextSize(12f);
        xAxis.setYOffset(0f);
        xAxis.setXOffset(0f);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(new String[]{"a", "b", "c", "d", "e"}));
        xAxis.setTextColor(Color.DKGRAY);

        // Y axis (radial values)
        YAxis yAxis = chart.getYAxis();
        yAxis.setLabelCount(5, true); // ile ticków po radialnej osi
        yAxis.setTextSize(12f);
        yAxis.setAxisMinimum(0f);
        yAxis.setAxisMaximum(100f); // dopasuj do skali danych
        yAxis.setDrawLabels(true);

        // Legend
        Legend l = chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        List<RadarEntry> entries1 = new ArrayList<>();
        entries1.add(new RadarEntry(80f)); // Siła
        entries1.add(new RadarEntry(65f)); // Szybkość
        entries1.add(new RadarEntry(70f)); // Zwinność
        entries1.add(new RadarEntry(50f)); // Wytrzymałość
        entries1.add(new RadarEntry(90f)); // Technika
        RadarDataSet set1 = new RadarDataSet(entries1, "Zawodnik A");
        set1.setColor(ColorTemplate.COLORFUL_COLORS[0]);
        set1.setFillColor(ColorTemplate.COLORFUL_COLORS[0]);
        set1.setDrawFilled(true);
        set1.setFillAlpha(180);
        set1.setLineWidth(2f);
        set1.setDrawHighlightCircleEnabled(true);
        set1.setDrawHighlightIndicators(false);

        // przykładowa druga seria
        List<RadarEntry> entries2 = new ArrayList<>();
        entries2.add(new RadarEntry(60f));
        entries2.add(new RadarEntry(75f));
        entries2.add(new RadarEntry(55f));
        entries2.add(new RadarEntry(80f));
        entries2.add(new RadarEntry(65f));
        RadarDataSet set2 = new RadarDataSet(entries2, "Zawodnik B");
        set2.setColor(ColorTemplate.COLORFUL_COLORS[1]);
        set2.setFillColor(ColorTemplate.COLORFUL_COLORS[1]);
        set2.setDrawFilled(true);
        set2.setFillAlpha(120);
        set2.setLineWidth(2f);

        ArrayList<RadarDataSet> sets = new ArrayList<>();
        sets.add(set1);
        sets.add(set2);

        // RadarData oczekuje listy datasetów; ale konstruktor ma różne przeciążenia
        RadarData data = new RadarData(set1, set2);
        data.setValueTextSize(10f);
        data.setDrawValues(true);
        data.setValueTextColor(Color.BLACK);

        chart.setData(data);
        chart.invalidate();
        chart.animateXY(1000, 1000);
    }
}