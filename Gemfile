source 'https://rubygems.org'
git_source(:github) { |repo| "https://github.com/#{repo}.git" }

ruby '2.5.0'

# Bundle edge Rails instead: gem 'rails', github: 'rails/rails'
gem 'rails', '~> 6.0.3', '>= 6.0.3.4'

# Pg is the Ruby interface to the PostgreSQL RDBMS
gem 'pg', '~> 1.1.4'

# Use Puma as the app server
gem 'puma', '~> 4.1'

# Pretty print Ruby objects to visualize their structure.
gem 'awesome_print', '~> 1.8'

# Use SCSS for stylesheets
gem 'sass-rails', '>= 6'

# Transpile app-like JavaScript. Read more: https://github.com/rails/webpacker
gem 'webpacker', '~> 4.0'

# Turbolinks makes navigating your web application faster. Read more: https://github.com/turbolinks/turbolinks
gem 'turbolinks', '~> 5'

# Allows generate your JSON in an object-oriented and convention-driven manner.
gem 'active_model_serializers', '~> 0.10.2'

# Reduces boot times through caching; required in config/boot.rb
gem 'bootsnap', '>= 1.4.2', require: false

# To split out complex seeds into multiple files
gem 'seedbank', '~> 0.5.0'

# Easy upload management for ActiveRecord
gem 'paperclip', '~> 6.0.0'

# The official AWS S3 SDK for Ruby. Provides access to storage service
gem 'aws-sdk-s3', '~> 1.50.0'

# Use Rack CORS for making cross-origin AJAX possible
gem 'rack-cors', '~> 1.0.5'

group :development, :test do
  gem 'binding_of_caller', '~> 0.8.0'
  gem 'byebug', '~> 11.0.0'
  gem 'dotenv-rails', '~> 2.7.0'
  gem 'factory_bot_rails', '~> 5.1.0'
  gem 'fuubar', '~> 2.4'
  gem 'pry-nav', '~> 0.3.0'
  gem 'pry-rails', '~> 0.3.9'
  gem 'rspec-rails', '~> 3.9.0'
  gem 'rspec-simplecov', '~> 0.2.2'
  gem 'rspec_junit_formatter', '~> 0.4.1'
  gem 'rubocop-performance', '~> 1.5.2'
  gem 'shoulda-matchers', '~> 4.1.0'
  gem 'simplecov', '~> 0.17.0'
end

group :development do
  gem 'better_errors', '~> 2.5.0'
  gem 'brakeman', '~> 4.7.0', require: false
  gem 'bullet', '~> 6.0.0'
  gem 'guard', '~> 2.14'
  gem 'guard-rspec', '~> 4.7', require: false
  gem 'rubocop', '~> 1.0', require: false
  gem 'spring', '~> 2.1.0'
  gem 'spring-commands-rspec', '~> 1.0.4'
  gem 'spring-watcher-listen', '~> 2.0.0'
end

group :test do
  gem 'database_cleaner', '~> 1.7.0'
  gem 'shoulda-callback-matchers', '~> 1.1.1'
end

# Windows does not include zoneinfo files, so bundle the tzinfo-data gem
gem 'tzinfo-data', platforms: [:mingw, :mswin, :x64_mingw, :jruby]
