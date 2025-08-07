package com.example.kikishop.ui.dashboard;

import android.content.Intent;
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
import com.example.kikishop.ui.inventory.InventoryActivity;
import com.example.kikishop.ui.order.OrdersActivity;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(com.example.kikishop.ui.dashboard.DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        HorizontalBarChart barChart = binding.barChart;

        dashboardViewModel.setItemsName(new MutableLiveData<String[]>(DataBaseResults.getInstance().getItemsName()));
        dashboardViewModel.setItemsValue(new MutableLiveData<ArrayList<BarEntry>>(DataBaseResults.getInstance().getItemsValue()));

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
        binding.ordersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), OrdersActivity.class);
                startActivity(i);
            }
        });
        binding.inventoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), InventoryActivity.class);
                startActivity(i);
            }
        });
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
}