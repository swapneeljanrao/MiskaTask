package com.mrcoder.retrofitexample.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmadrosid.svgloader.SvgLoader;
import com.mrcoder.retrofitexample.R;
import com.mrcoder.retrofitexample.databinding.CountrySingleItemLayoutBinding;
import com.mrcoder.retrofitexample.model.Border;
import com.mrcoder.retrofitexample.model.Country;
import com.mrcoder.retrofitexample.model.Language;

import java.util.List;

import timber.log.Timber;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountyViewHolder> {

    Context mCtx;
    List<Country> countryList;
    Activity activity;
    CountrySingleItemLayoutBinding binding;

    public CountryAdapter(Context mCtx, Activity activity, List<Country> countryList) {
        this.mCtx = mCtx;
        this.activity = activity;
        this.countryList = countryList;
    }

    @NonNull
    @Override
    public CountyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.country_single_item_layout, parent, false);

        return new CountyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountyViewHolder holder, int position) {
        Country country = countryList.get(position);
        Timber.e(country.toString());

//        Glide.with(mCtx).load(country.getFlag()).into(holder.countryImage);

        SvgLoader.pluck()
                .with((Activity) mCtx)
                .setPlaceHolder(R.mipmap.ic_launcher, R.mipmap.ic_launcher)
                .load(countryList.get(position).getFlag(), holder.countryImage);

        holder.countryname.setText("Country Name :" + country.getName());
        holder.countrycapital.setText("Capital City :" + country.getCapital());
        holder.countrRregion.setText("Continent :" + country.getRegion());
        holder.countrySubregion.setText("Sub-Continent :" + country.getSubregion());
        holder.countryPopulation.setText("Population :" + country.getPopulation());
        /*List<Language> languages = country.getLanguages();
        for (int i = 0; i <= languages.size(); i++) {
            binding.tvCountryLanguages.setText(languages.toString());
        }
        StringBuilder builder = new StringBuilder();
        for (Border borders : country.getBorders()) {
            builder.append(borders + "\n");
        }
        binding.tvCountryBorders.setText(builder);*/
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public class CountyViewHolder extends RecyclerView.ViewHolder {
        ImageView countryImage;
        TextView countryname, countrycapital, countrRregion, countrySubregion, countryPopulation;


        public CountyViewHolder(@NonNull View itemView) {
            super(itemView);
            countryImage = itemView.findViewById(R.id.iv_country_image);
            countryname = itemView.findViewById(R.id.tv_country_name);
            countrycapital = itemView.findViewById(R.id.tv_country_capital);
            countrRregion = itemView.findViewById(R.id.tv_country_region);
            countrySubregion = itemView.findViewById(R.id.tv_country_sub_region);
            countryPopulation = itemView.findViewById(R.id.tv_country_population);
            /*TextView countryBorders = itemView.findViewById(R.id.tv_country_borders);
            TextView countryLanguages = itemView.findViewById(R.id.tv_country_languages);*/

        }
    }
}
