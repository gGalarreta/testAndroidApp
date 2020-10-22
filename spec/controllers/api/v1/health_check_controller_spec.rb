# frozen_string_literal: true

require 'rails_helper'

RSpec.describe Api::V1::HealthCheckController, type: :controller do
  describe 'GET #index' do
    it 'returns a success' do
      get :index
      expect(response).to have_http_status(:ok)
    end
  end
end
