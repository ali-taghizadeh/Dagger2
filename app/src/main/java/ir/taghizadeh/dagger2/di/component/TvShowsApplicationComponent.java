package ir.taghizadeh.dagger2.di.component;

import com.squareup.picasso.Picasso;

import dagger.Component;
import ir.taghizadeh.dagger2.di.module.ContextModule;
import ir.taghizadeh.dagger2.di.module.PicassoModule;
import ir.taghizadeh.dagger2.di.module.TvShowsServiceModule;
import ir.taghizadeh.dagger2.di.scope.TvShowsApplicationScope;
import ir.taghizadeh.dagger2.network.TvShowsService;

@TvShowsApplicationScope
@Component(modules = {TvShowsServiceModule.class, PicassoModule.class, ContextModule.class})
public interface TvShowsApplicationComponent {

    TvShowsService getTvShowsService();
    Picasso getPicasso();

}
