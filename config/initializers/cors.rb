Rails.application.config.middleware.insert_before 0, Rack::Cors do
  allow do
    origins ENV['ORIGIN_CORS_DOMAINS'].to_s.split(',').map { |domain| [/(http|https):\/\/(.*?)\.#{domain}/, /(http|https):\/\/#{domain}/] }.flatten
    resource '*',
             headers: :any,
             methods: %i[get post put patch delete options head],
             expose: %w[Content-Disposition]
  end
end
