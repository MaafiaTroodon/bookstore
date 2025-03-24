package ca.dal.cs.csci3130.a4.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import ca.dal.cs.csci3130.a4.R;
import ca.dal.cs.csci3130.a4.core.AppConstants;
import ca.dal.cs.csci3130.a4.factory.Item;
import ca.dal.cs.csci3130.a4.factory.ItemCRUD;
import ca.dal.cs.csci3130.a4.util.SearchRecyclerViewAdapter;

public class ProductActivity extends AppCompatActivity implements SearchRecyclerViewAdapter.ItemClickListener {
    SearchRecyclerViewAdapter adapter;
    ItemCRUD crud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        this.loadCategorySpinner();
        this.setupSearchButton();
        this.crud = new ItemCRUD();
    }

    protected void loadCategorySpinner() {
        List<String> categories = new ArrayList<>();
        categories.add("Select a category");
        categories.add(AppConstants.FOOD);
        categories.add(AppConstants.BOOK);
        Spinner catSpinner = findViewById(R.id.categorySpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        catSpinner.setAdapter(adapter);
    }

    protected String getSelectedCategory() {
        Spinner catSpinner = findViewById(R.id.categorySpinner);
        return catSpinner.getSelectedItem().toString();
    }

    protected void showSearchResults(ArrayList<Item> items, ArrayList<String> headers) {
        this.adapter = new SearchRecyclerViewAdapter(this, items, headers);
        this.adapter.setItemClickListener(this);
        RecyclerView resultView = findViewById(R.id.resultsRecyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        resultView.setLayoutManager(manager);
        DividerItemDecoration decoration = new DividerItemDecoration(resultView.getContext(), manager.getOrientation());
        resultView.addItemDecoration(decoration);
        resultView.setAdapter(this.adapter);
    }


    protected ArrayList<Item> collectRetrievedResults(String category) {
        return this.crud.collectRetrievedItems(category);
    }

    protected ArrayList<String> collectItemHeaders() {
        return this.crud.collectItemHeaders();
    }

    protected void setupSearchButton() {
        Button searchButton = findViewById(R.id.searchButton);
        searchButton.setOnClickListener(view -> {
            String category = getSelectedCategory();
            ArrayList<Item> results = collectRetrievedResults(category);
            ArrayList<String> headers = collectItemHeaders();
            showSearchResults(results, headers);
        });
    }

    @Override
    public void onItemClick(View view, int position) {
        Item selected = this.adapter.getItem(position);
        showItemDetails(selected);
    }

    protected void showItemDetails(Item selected) {
        Intent paymentIntent = new Intent(this, PaymentActivity.class);
        paymentIntent.putExtra("itemPrice", selected.getPrice());
        startActivity(paymentIntent);
    }

}