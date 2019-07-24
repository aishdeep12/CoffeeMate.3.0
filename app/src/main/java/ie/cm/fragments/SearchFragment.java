package ie.cm.fragments;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import ie.cm.R;
import ie.cm.activities.Search;

public class SearchFragment extends CoffeeFragment implements AdapterView.OnItemSelectedListener, TextWatcher {


	public SearchFragment() {
		// Required empty public constructor
	}
	public static SearchFragment newInstance() {
		SearchFragment fragment = new SearchFragment();
		return fragment;
	}



	@Override
	public void onAttach(Context c) {
		super.onAttach(c);

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter
				.createFromResource(getActivity(), R.array.coffeeTypes,
						android.R.layout.simple_spinner_item);


		spinnerAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		Spinner spinner = ((Spinner) activity.findViewById(R.id.searchCoffeeTypeSpinner));
		spinner.setAdapter(spinnerAdapter);
		super.onCreate(savedInstanceState);
		spinner.setOnItemSelectedListener(this);

		EditText nameText = (EditText)activity.findViewById(R.id.searchCoffeeNameEditText); nameText.addTextChangedListener(this);



	}

	@Override
	public void onClick(View view) {

		super.onClick(view);
	}

	@Override
	public void onStart() {
		super.onStart();
	}


	@Override
	public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

	}

	@Override
	public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

		coffeeFilter.filter(charSequence);



	}

	@Override
	public void afterTextChanged(Editable editable) {

	}

	@Override
	public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
		String selected = adapterView.getItemAtPosition(i).toString();
		if (selected != null) {
			if (selected.equals("All Types")) {
				coffeeFilter.setFilter("all");
			} else if (selected.equals("Favourites")) {
				coffeeFilter.setFilter("favourites"); }
			coffeeFilter.filter(""); }

	}

	@Override
	public void onNothingSelected(AdapterView<?> adapterView) {

	}


}