package com.example.kikishop.ui.notifications;

import static android.view.View.TEXT_ALIGNMENT_CENTER;
import static android.widget.LinearLayout.VERTICAL;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.kikishop.R;
import com.example.kikishop.data.db.Order;
import com.example.kikishop.databinding.FragmentNotificationsBinding;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);
        Order o = new Order(1,"asdadsa", "1,3,5,2", 42, "Polanki 23a, 32-34 Gdańsk", "addres1@gmale.com", "new");
        ArrayList<Order> fakeList = o.fakeData();
        ArrayList<Order> newOrder = new ArrayList<>();
        ArrayList<Order> processedOrder = new ArrayList<>();
        ArrayList<Order> finishOrder = new ArrayList<>();
        ArrayList<Order> deliveredOrder = new ArrayList<>();

        for (Order ord : fakeList) {
            if (ord.getStatus().equals("new")) {
                newOrder.add(ord);
            }
            if (ord.getStatus().equals("processed")) {
                processedOrder.add(ord);
            }
            if (ord.getStatus().equals("finish")) {
                finishOrder.add(ord);
            }
            if (ord.getStatus().equals("delivered")) {
                deliveredOrder.add(ord);
            }
        }

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final TextView textView = binding.textNotifications;
        setNewOrdersTable(newOrder, binding);
        setProcessedOrderTable(processedOrder, binding);
        setFinishOrderTable(finishOrder, binding);
        setDeliveredOrderTable(deliveredOrder, binding);
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void setNewOrdersTable(ArrayList<Order> orders, FragmentNotificationsBinding binding) {
            LinearLayout layout = binding.newOrder;

        for (Order o : orders
        ) {
            LinearLayout record = new LinearLayout(getContext());
            LinearLayout header = new LinearLayout(getContext());
            LinearLayout content = new LinearLayout(getContext());

            record.setOrientation(VERTICAL);
            record.setTextAlignment(TEXT_ALIGNMENT_CENTER);

            TextView id = new TextView(getContext());
            TextView name = new TextView(getContext());
            TextView items = new TextView(getContext());
            TextView value = new TextView(getContext());

            id.setText("order: " + (o.getId()));
            name.setText(o.getName());
            items.setText(o.getItems());
            value.setText("value: " + (o.getValue()));

            Button button = new Button(getContext());
            button.setText(getContext().getString(R.string.contact));
            button.setId(o.getId());
            button.setOnClickListener(v -> {

                Intent i = new Intent();

            });

            header.addView(id);
            content.addView(name);
            content.addView(items);
            content.addView(value);
            content.addView(button);
            record.addView(header);
            record.addView(content);
            layout.addView(record);
        }
    }

    public void setProcessedOrderTable(ArrayList<Order> orders, FragmentNotificationsBinding binding) {
        LinearLayout layout = binding.processedOrder;

        for (Order o : orders
        ) {
            LinearLayout record = new LinearLayout(getContext());
            LinearLayout header = new LinearLayout(getContext());
            LinearLayout content = new LinearLayout(getContext());

            record.setOrientation(VERTICAL);
            record.setTextAlignment(TEXT_ALIGNMENT_CENTER);

            TextView id = new TextView(getContext());
            TextView name = new TextView(getContext());
            TextView items = new TextView(getContext());
            TextView value = new TextView(getContext());

            id.setText("order: " + (o.getId()));
            name.setText(o.getName());
            items.setText(o.getItems());
            value.setText("value: " + (o.getValue()));

            Button button = new Button(getContext());
            button.setText(getContext().getString(R.string.pack));
            button.setId(o.getId());

            header.addView(id);
            content.addView(name);
            content.addView(items);
            content.addView(value);
            content.addView(button);
            record.addView(header);
            record.addView(content);
            layout.addView(record);
        }
    }

    public void setFinishOrderTable(ArrayList<Order> orders, FragmentNotificationsBinding binding) {
        LinearLayout layout = binding.finishOrder;

        for (Order o : orders
        ) {
            LinearLayout record = new LinearLayout(getContext());
            LinearLayout header = new LinearLayout(getContext());
            LinearLayout content = new LinearLayout(getContext());

            record.setOrientation(VERTICAL);
            record.setTextAlignment(TEXT_ALIGNMENT_CENTER);

            TextView id = new TextView(getContext());
            TextView name = new TextView(getContext());
            TextView items = new TextView(getContext());
            TextView value = new TextView(getContext());

            id.setText("order: " + (o.getId()));
            name.setText(o.getName());
            items.setText(o.getItems());
            value.setText("value: " + (o.getValue()));

            Button button = new Button(getContext());
            button.setText(getContext().getString(R.string.send));
            button.setId(o.getId());

            header.addView(id);
            content.addView(name);
            content.addView(items);
            content.addView(value);
            content.addView(button);
            record.addView(header);
            record.addView(content);
            layout.addView(record);
        }
    }
    public void setDeliveredOrderTable(ArrayList<Order> orders, FragmentNotificationsBinding binding) {
        LinearLayout layout = binding.deliveredOrder;

        for (Order o : orders
        ) {
            LinearLayout record = new LinearLayout(getContext());
            LinearLayout header = new LinearLayout(getContext());
            LinearLayout content = new LinearLayout(getContext());

            record.setOrientation(VERTICAL);
            record.setTextAlignment(TEXT_ALIGNMENT_CENTER);

            TextView id = new TextView(getContext());
            TextView name = new TextView(getContext());
            TextView items = new TextView(getContext());
            TextView value = new TextView(getContext());

            id.setText("order: " + (o.getId()));
            name.setText(o.getName());
            items.setText(o.getItems());
            value.setText("value: " + (o.getValue()));

            Button button = new Button(getContext());
            button.setText(getContext().getString(R.string.send));
            button.setId(o.getId());

            header.addView(id);
            content.addView(name);
            content.addView(items);
            content.addView(value);
            content.addView(button);
            record.addView(header);
            record.addView(content);
            layout.addView(record);
        }
    }


}