package br.com.madeinweb.labs.countmalandra.total

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.madeinweb.labs.countmalandra.CountApplication
import br.com.madeinweb.labs.countmalandra.R
import br.com.madeinweb.labs.countmalandra.databinding.ActivityTotalBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import javax.inject.Inject

class TotalActivity : AppCompatActivity(), TotalContract.View {

    private var mBinding: ActivityTotalBinding? = null
    private var mTotalPresenter: TotalContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_total)

        val countApplication = applicationContext as CountApplication
        countApplication.diComponent?.inject(this)

        val binding = mBinding
        if (binding != null) {
            Glide.with(this)
                    .load(R.drawable.vai_malandra_background)
                    .apply(RequestOptions.centerCropTransform())
                    .into(binding.ivBackground)
        }
    }

    @Inject
    fun setPresenter(totalPresenter: TotalContract.Presenter) {
        mTotalPresenter = totalPresenter
        mTotalPresenter?.attach(this)
    }

    override fun onCountReady(count: Int) {
        mBinding?.tvCounter?.text = getString(R.string.value, count)
    }

    override fun onLoadCountFailed(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        mTotalPresenter?.detach()
        super.onDestroy()
    }
}
