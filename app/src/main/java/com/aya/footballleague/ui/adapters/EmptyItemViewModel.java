package com.aya.footballleague.ui.adapters;

public class EmptyItemViewModel {

    private EmptyItemViewModelListener mListener;

    public EmptyItemViewModel(EmptyItemViewModelListener mListener) {
        this.mListener = mListener;
    }

    public void onRetryClicked() {
        mListener.onRetryClicked();
    }

    public interface EmptyItemViewModelListener {
        void onRetryClicked();
    }
}
