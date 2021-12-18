package examples

import cats.effect.IO
import cats.effect.IOApp
import org.http4s.ember.server.EmberServerBuilder

object Demo extends IOApp.Simple {

  def run: IO[Unit] =
    EmberServerBuilder
      .default[IO]
      .build
      .useForever

}
