# frozen_string_literal: true

module Api
  module V1
    class HealthCheckController < Api::ApiV1Controller
      def index
        render json: {
          message: 'it works',
          status: :ok
        }
      end
    end
  end
end
