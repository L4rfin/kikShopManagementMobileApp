package com.example.kikishop.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import com.example.kikishop.data.db.DataBaseResults;
import com.example.kikishop.data.db.TopSale;
import com.example.kikishop.databinding.FragmentHomeBinding;
import com.example.kikishop.ui.inventory.InventoryActivity;
import com.example.kikishop.ui.order.OrdersActivity;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        DataBaseResults dataBaseResults = DataBaseResults.getInstance();
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        TopSale topSale = TopSale.getInstance();
        final TextView topSId = binding.topSId;
        homeViewModel.setTopSId(topSale.getId());
        final TextView topSName = binding.topSName;
        homeViewModel.setTopSName(topSale.getName());
        final TextView topSStock = binding.topSStock;
        homeViewModel.setTopSStock(topSale.getStock());
        final TextView topSSale = binding.topSSales;
        homeViewModel.setTopSSale(topSale.getSale());
        final  TextView visitors = binding.visitors;
        homeViewModel.setVisitors(dataBaseResults.getVisitors());
        homeViewModel.getVisitors().observe(getViewLifecycleOwner(), visitors::setText);
        homeViewModel.getTopSId().observe(getViewLifecycleOwner(), topSId::setText);
        homeViewModel.getTopSName().observe(getViewLifecycleOwner(), topSName::setText);
        homeViewModel.getTopSStock().observe(getViewLifecycleOwner(), topSStock::setText);
        homeViewModel.getTopSSale().observe(getViewLifecycleOwner(), topSSale::setText);

        binding.inventoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), InventoryActivity.class);
                startActivity(i);
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}