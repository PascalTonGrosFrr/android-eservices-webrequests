package android.eservices.webrequests.presentation.viewmodel;


import android.eservices.webrequests.data.api.repository.bookdisplay.BookDisplayRepository;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory implements ViewModelProvider.Factory {
    private final BookDisplayRepository bookDisplayRepository;

    public ViewModelFactory(BookDisplayRepository bookDisplayRepository) {
        this.bookDisplayRepository = bookDisplayRepository;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(BookSearchViewModel.class)) {
            return (T) new BookSearchViewModel(bookDisplayRepository);
        } else if (modelClass.isAssignableFrom(BookFavoriteViewModel.class)){
            return (T) new BookFavoriteViewModel(bookDisplayRepository);
        }
        //Handle favorite view model case
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}