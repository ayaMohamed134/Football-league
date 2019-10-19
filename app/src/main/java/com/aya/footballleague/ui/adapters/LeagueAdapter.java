package com.aya.footballleague.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.aya.footballleague.data.model.LeaguesResponse;
import com.aya.footballleague.databinding.EmptyItemBinding;
import com.aya.footballleague.databinding.LeagueItemBinding;
import com.aya.footballleague.ui.base.BaseViewHolder;

import java.util.List;

public class LeagueAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;

    public static final int VIEW_TYPE_NORMAL = 1;

    private List<LeaguesResponse.League> mData;

    private LeagueAdapterListener mListener;

    public LeagueAdapter(List<LeaguesResponse.League> mData) {
        this.mData = mData;
    }

    @Override
    public int getItemCount() {
        if (mData != null && mData.size() > 0) {
            return mData.size();
        } else {
            return 1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mData != null && !mData.isEmpty()) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                LeagueItemBinding leagueItemBinding = LeagueItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new NormalViewHolder(leagueItemBinding);
            case VIEW_TYPE_EMPTY:
            default:
                EmptyItemBinding emptyViewBinding = EmptyItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new EmptyViewHolder(emptyViewBinding);
        }
    }

    public void addItems(List<LeaguesResponse.League> mData) {
        this.mData.addAll(mData);
        notifyDataSetChanged();
    }

    public void clearItems() {
        this.mData.clear();
    }

    public void setListener(LeagueAdapterListener listener) {
        this.mListener = listener;
    }

    public interface LeagueAdapterListener {
        void onItemClicked(String league_id);
        void onRetryClick();
    }

    public class NormalViewHolder extends BaseViewHolder implements LeagueItemViewModel.LeagueItemViewModelListener {

        private LeagueItemBinding mBinding;

        private LeagueItemViewModel mLeagueItemViewModel;

        public NormalViewHolder(LeagueItemBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            final LeaguesResponse.League league = mData.get(position);
            mLeagueItemViewModel = new LeagueItemViewModel(league, this);
            mBinding.setViewModel(mLeagueItemViewModel);

            // Immediate Binding
            // When a variable or observable changes, the binding will be scheduled to change before
            // the next frame. There are times, however, when binding must be executed immediately.
            // To force execution, use the executePendingBindings() method.
            mBinding.executePendingBindings();
        }

        @Override
        public void onItemClick(String league_id) {
            mListener.onItemClicked(league_id);
        }
    }

    public class EmptyViewHolder extends BaseViewHolder implements EmptyItemViewModel.EmptyItemViewModelListener {

        private EmptyItemBinding mBinding;

        public EmptyViewHolder(EmptyItemBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            EmptyItemViewModel emptyItemViewModel = new EmptyItemViewModel(this);
            mBinding.setViewModel(emptyItemViewModel);
        }

        @Override
        public void onRetryClicked() {
            mListener.onRetryClick();
        }
    }
}